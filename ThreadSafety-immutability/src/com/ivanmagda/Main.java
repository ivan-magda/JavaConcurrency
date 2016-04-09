package com.ivanmagda;

public class Main {

    /**
     * Example of the thread safety object.
     * <p>
     * We can make sure that objects shared between threads are never updated by any of the threads
     * by making the shared objects immutable, and thereby thread safe.
     * <p>
     * Once an ImmutableValue instance is created you cannot change its value.
     * <p>
     * The ImmutableValue class is thread safe, but the use of it is not.
     */
    public class ImmutableValue {

        private int value = 0;

        public ImmutableValue(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        /**
         * Performs thread safe addition operation on the ImmutableValue instance.
         *
         * @param value - value to add.
         * @return - a new instance with the value resulting from the operation.
         */
        public ImmutableValue add(int value) {
            return new ImmutableValue(this.value + value);
        }

    }

    /**
     * It is important to remember, that even if an object is immutable and thereby thread safe,
     * the reference to this object may not be thread safe.
     */

    /**
     * The Calculator class holds a reference to an ImmutableValue instance.
     * Notice how it is possible to change that reference through both the setValue() and add()
     * methods.
     * Therefore, even if the Calculator class uses an immutable object internally,
     * it is not itself immutable, and therefore not thread safe.
     * In other words: The ImmutableValue class is thread safe, but the use of it is not.
     * This is something to keep in mind when trying to achieve thread safety through
     * immutability.
     */
    public class Calculator {
        private ImmutableValue immutableValue = null;

        public ImmutableValue getValue() {
            return immutableValue;
        }

        public void setValue(ImmutableValue immutableValue) {
            this.immutableValue = immutableValue;
        }

        public void add(int value) {
            immutableValue = immutableValue.add(value);
        }
    }

    /**
     * To make the Calculator class thread safe you could have declared the getValue(),
     * setValue(), and add() methods synchronized. That would have done the trick.
     */
    public class CalculatorThreadSafe {
        private ImmutableValue immutableValue = null;

        public ImmutableValue getValue() {
            synchronized (this) {
                return immutableValue;
            }
        }

        public void setValue(ImmutableValue immutableValue) {
            synchronized (this) {
                this.immutableValue = immutableValue;
            }
        }

        public void add(int value) {
            synchronized (this) {
                immutableValue = immutableValue.add(value);
            }
        }
    }

    public static void main(String[] args) {
    }
}
