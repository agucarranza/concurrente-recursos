package com.concurrente.tp1;

import java.util.ArrayList;
import java.util.List;

public class Registers {

    private static final int PAX = 186;

    public static int getPax() {
        return PAX;
    }

    public class Reservation {
        private boolean checked = false;

        public boolean isChecked() {
            return checked;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
        }

        private boolean canceled = false;

        public boolean isCanceled() {
            return canceled;
        }

        public void setCanceled(boolean canceled) {
            this.canceled = canceled;
        }

        private State state = State.UNKNOWN;

        public State getState() {
            return state;
        }

        public void setState(State state) {
            this.state = state;
        }
    }

    private ArrayList<Reservation> reservations = new ArrayList<>(PAX);

    public List<Reservation> getReservations() {
        return reservations;
    }

    private ArrayList<Integer> pending = new ArrayList<>();

    public List<Integer> getPending() {
        return pending;
    }

    private ArrayList<Integer> confirmed = new ArrayList<>();

    public List<Integer> getConfirmed() {
        return confirmed;
    }

    private ArrayList<Integer> canceled = new ArrayList<>();

    public List<Integer> getCanceled() {
        return canceled;
    }

    private ArrayList<Integer> verified = new ArrayList<>();

    public List<Integer> getVerified() {
        return verified;
    }

}
