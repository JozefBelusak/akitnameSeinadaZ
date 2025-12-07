import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Locale;
import java.util.function.BiPredicate;
import java.util.function.LongBinaryOperator;

public final class StackLangMain {
    private static final String DEFAULT_PROGRAM = "load 3 load 4 add dup mul";

    public static void main(String[] args) throws IOException {
        List<String> tokens;
        if (args.length == 0) {
            tokens = readTokensFromStdIn();
            if (tokens.isEmpty()) {
                tokens = Arrays.asList(DEFAULT_PROGRAM.split("\\s+"));
                System.out.println("No input detected, running default program: " + DEFAULT_PROGRAM);
            } else {
                System.out.println("Read " + tokens.size() + " tokens from standard input.");
            }
        } else {
            tokens = Arrays.asList(args);
        }

        try {
            List<Instruction> program = ProgramParser.parse(tokens);
            StackMachine machine = new StackMachine();
            machine.execute(program);
            System.out.println("Executed " + program.size() + " commands.");
            System.out.println("Final stack (top -> bottom): " + machine.snapshot());
        } catch (IllegalArgumentException | IllegalStateException ex) {
            System.err.println("Error: " + ex.getMessage());
            System.exit(1);
        }
    }

    private static List<String> readTokensFromStdIn() throws IOException {
        List<String> tokens = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String part : line.trim().split("\\s+")) {
                    if (!part.isEmpty()) {
                        tokens.add(part);
                    }
                }
            }
        }
        return tokens;
    }

    private interface Instruction {
        void apply(Deque<Long> stack);
    }

    private static final class LoadInstruction implements Instruction {
        private final long value;

        LoadInstruction(long value) {
            if (value < 0) {
                throw new IllegalArgumentException("load expects a natural number, got " + value);
            }
            this.value = value;
        }

        @Override
        public void apply(Deque<Long> stack) {
            stack.push(value);
        }

        @Override
        public String toString() {
            return "load " + value;
        }
    }

    private static final class BinaryInstruction implements Instruction {
        private final String name;
        private final LongBinaryOperator operator;
        private final BiPredicate<Long, Long> guard;

        BinaryInstruction(String name, LongBinaryOperator operator, BiPredicate<Long, Long> guard) {
            this.name = name;
            this.operator = operator;
            this.guard = guard;
        }

        @Override
        public void apply(Deque<Long> stack) {
            long first = StackMachine.pop(stack, name + " (top operand)");
            long second = StackMachine.pop(stack, name + " (second operand)");
            if (!guard.test(first, second)) {
                throw new IllegalStateException(
                    name + " guard violated for operands (" + second + ", " + first + ")");
            }
            long result = operator.applyAsLong(first, second);
            stack.push(result);
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private static final class DupInstruction implements Instruction {
        @Override
        public void apply(Deque<Long> stack) {
            long value = StackMachine.pop(stack, "dup");
            stack.push(value);
            stack.push(value);
        }

        @Override
        public String toString() {
            return "dup";
        }
    }

    private static final class ProgramParser {
        private ProgramParser() {}

        static List<Instruction> parse(List<String> tokens) {
            List<Instruction> program = new ArrayList<>();
            int i = 0;
            while (i < tokens.size()) {
                String token = tokens.get(i).toLowerCase(Locale.ROOT);
                switch (token) {
                    case "load" -> {
                        ensureHasNext(tokens, i, "load");
                        long value = parseNumber(tokens.get(i + 1));
                        program.add(new LoadInstruction(value));
                        i += 2;
                    }
                    case "add" -> {
                        program.add(new BinaryInstruction("add", Long::sum, (a, b) -> true));
                        i++;
                    }
                    case "sub" -> {
                        program.add(new BinaryInstruction(
                            "sub",
                            (a, b) -> b - a,
                            (a, b) -> b >= a
                        ));
                        i++;
                    }
                    case "mul" -> {
                        program.add(new BinaryInstruction("mul", (a, b) -> a * b, (a, b) -> true));
                        i++;
                    }
                    case "dup" -> {
                        program.add(new DupInstruction());
                        i++;
                    }
                    case "" -> i++;
                    default -> throw new IllegalArgumentException("Unknown token: " + token);
                }
            }
            return program;
        }

        private static void ensureHasNext(List<String> tokens, int index, String cmdName) {
            if (index + 1 >= tokens.size()) {
                throw new IllegalArgumentException(cmdName + " expects an argument");
            }
        }

        private static long parseNumber(String literal) {
            try {
                long value = Long.parseLong(literal);
                if (value < 0) {
                    throw new IllegalArgumentException("Natural numbers only, got " + literal);
                }
                return value;
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException("Invalid natural number: " + literal, ex);
            }
        }
    }

    private static final class StackMachine {
        private final Deque<Long> stack = new ArrayDeque<>();

        void execute(List<Instruction> program) {
            for (Instruction instruction : program) {
                instruction.apply(stack);
            }
        }

        List<Long> snapshot() {
            return new ArrayList<>(stack);
        }

        static long pop(Deque<Long> stack, String context) {
            Long value = stack.pollFirst();
            if (value == null) {
                throw new IllegalStateException("Stack underflow while executing " + context);
            }
            return value;
        }
    }
}
