package com.concurrente.tp1;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import com.concurrente.tp1.Registers.Reservation;

/*
 * Proceso de Pago: Este proceso es ejecutado por dos hilos, y se encarga de 
 * verificar el pago de las reservas pendientes. Cada hilo toma una reserva 
 * aleatoria del registro de reservas pendientes y realiza una verificación de 
 * pago. Se establece una probabilidad del 90% de que el pago sea aprobado y un 
 * 10% de que sea rechazado. Si el pago es aprobado, la reserva se elimina del 
 * registro de pendientes, y se agrega al registro de reservas confirmadas; de 
 * lo contrario, el asiento pasa a estado descartado mientras que la reserva se
 * marca como cancelada, se elimina del registro de pendientes y se agrega al 
 * registro de reservas canceladas.
*/
public class PaymentProc implements Runnable {

    private Random rand = new Random();
    final Logger logger = Logger.getLogger(PaymentProc.class.getName());
    private Registers registers;

    public PaymentProc(Registers registers) {
        this.registers = registers;
    }

    @Override
    public void run() {
        boolean isStopped = false;
        List<Reservation> reservations = registers.getReservations();
        List<Integer> pendings = registers.getPending();
        List<Integer> confirmed = registers.getConfirmed();
        List<Integer> canceled = registers.getCanceled();

        while (!isStopped) {
            try {
                int randomIndex = rand.nextInt(pendings.size());
                Integer randomPending = pendings.get(randomIndex);
                if (paymentVerification()) {
                    pendings.remove(randomPending);
                    confirmed.add(randomPending);
                } else {
                    reservations.get(randomPending).setState(State.DISCARDED);
                    reservations.get(randomPending).setChecked(true);
                    pendings.remove(randomPending);
                    canceled.add(randomPending);
                }

            } catch (Exception e) {
                logger.severe(e.getMessage());
                isStopped = true;
            }

        }
    }

    private boolean paymentVerification() {
        double trueWeight = 0.9;
        double randomNumber = rand.nextDouble();
        return (randomNumber < trueWeight);
    }

}