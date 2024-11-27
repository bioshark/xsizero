package org.roly.domain.model;

public record Cell(
    State state,
    String position
) {

    public enum State {
        X("X"),
        O("0"),
        EMPTY(" ");

        State(String value) {
            this.value = value;
        }

        private final String value;

        @Override
        public String toString() {
            return value;
        }
    }

    public boolean isOccupied() {
        return state != State.EMPTY;
    }

    @Override
    public String toString() {
        return state.value + " - " + position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Cell cell = (Cell) o;
        return !state.equals(State.EMPTY) && state == cell.state;
    }
}
