package com.concurrente.tp1;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

        final Logger logger = Logger.getLogger(Main.class.getName());
        logger.severe("Init project!");

        Registers registers = new Registers();

        ReservationProc rProc = new ReservationProc(registers);
        PaymentProc pProc = new PaymentProc(registers);
        VerificationProc vProc = new VerificationProc(registers);
        CancelationProc cProc = new CancelationProc(registers);

        Thread rProcThread = new Thread(rProc);
        Thread pProcThread = new Thread(pProc);
        Thread vProcThread = new Thread(vProc);
        Thread cProcThread = new Thread(cProc);
    }
}
