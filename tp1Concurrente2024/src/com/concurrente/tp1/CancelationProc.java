package com.concurrente.tp1;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import com.concurrente.tp1.Registers.Reservation;

/*
 * Proceso de Cancelación/Validación: Si un usuario decide cancelar su reserva,
 * se pasa al proceso de cancelación. Tres hilos se encargan de cancelar las 
 * reservas. Cada hilo selecciona una reserva aleatoria de las reservas 
 * confirmadas y la cancela con una probabilidad del 10%. Si la reserva es 
 * cancelada, se elimina del registro de reservas confirmadas y se agrega al 
 * registro de reservas canceladas mientras que el asiento pasa a estado 
 * descartado. Si la reserva no es cancelada, la misma se marca como "checked".
*/
public class CancelationProc implements Runnable {

    private Random rand = new Random();
    final Logger logger = Logger.getLogger(CancelationProc.class.getName());
    private Registers registers;

    public CancelationProc(Registers registers) {
        this.registers = registers;
    }

    @Override
    public void run() {
        boolean isStopped = false;
        List<Reservation> reservations = registers.getReservations();
        List<Integer> confirmed = registers.getConfirmed();
        List<Integer> canceled = registers.getCanceled();

        while (!isStopped) {
            try {
                int randomIndex = rand.nextInt(confirmed.size());
                Integer randomConfirmed = confirmed.get(randomIndex);
                if (runCancelation()) {
                    confirmed.remove(randomConfirmed);
                    canceled.add(randomConfirmed);
                    reservations.get(randomConfirmed).setState(State.DISCARDED);
                } else {
                    reservations.get(randomConfirmed).setChecked(true);
                }

            } catch (Exception e) {
                logger.severe(e.getMessage());
                isStopped = true;
            }
        }

    }

    private boolean runCancelation() {
        double trueWeight = 0.1;
        double randomNumber = rand.nextDouble();
        return (randomNumber < trueWeight);
    }

}
