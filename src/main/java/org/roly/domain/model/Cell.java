package org.roly.domain.model;

import java.util.Objects;

public record Cell(
    State state
) {

    public enum State {
        X("X"),
        O("O"),
        EMPTY(" ");

        State(String value) {
            this.value = value;
        }

        private String value;
    }

    @Override
    public String toString() {
        return state.value.toString();
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
