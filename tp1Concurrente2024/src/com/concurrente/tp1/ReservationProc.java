package com.concurrente.tp1;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import com.concurrente.tp1.Registers.Reservation;

/*
 * Proceso de Reserva: Este proceso se encarga de recibir las solicitudes de 
 * reserva de los usuarios. Se tienen tres hilos que ejecutan este proceso. 
 * Cada hilo intenta reservar un asiento aleatorio en la matriz, verificando 
 * que esté disponible. Si el asiento no está libre, el hilo debe buscar otro 
 * asiento que sí lo esté. Una vez reservado el asiento, el mismo se marca como 
 * ocupado y se registra la reserva pendiente en el registro de reservas 
 * pendientes.
*/
public class ReservationProc implements Runnable {

    final Logger logger = Logger.getLogger(ReservationProc.class.getName());
    private Registers registers;
    private Random rand = new Random();

    public ReservationProc(Registers registers) {
        this.registers = registers;
    }

    @Override
    public void run() {
        boolean isStopped = false;
        final int MIN = 0;
        final int MAX = Registers.getPax() - 1;
        List<Integer> pendings = registers.getPending();
        List<Reservation> reservations = registers.getReservations();

        while (!isStopped) {
            try {
                int randomNumber = rand.nextInt(MAX - MIN + 1) + MIN;
                if (reservations.get(randomNumber).getState() == State.FREE) {
                    reservations.get(randomNumber).setState(State.BUSY);
                    pendings.add(randomNumber);
                }
            } catch (Exception e) {
                logger.severe(e.getMessage());
                isStopped = true;
            }
        }
    }
}
