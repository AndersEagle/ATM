package org.example;

import java.util.Scanner;


public class BankProgram {
   private Konto[] kontoLista; // Alla konton på banken
   private int antalKonton = 3;

   private Konto aktivtKonto = null; // Referens till det konto som hanteras
   private Scanner scanner = new Scanner(System.in);
   public BankProgram(){
      kontoLista = new Konto[antalKonton];
      // Ger pin-koder till de tre kontona samt annat saldo på Spar- & Fondkonto
      kontoLista[0] = new Konto("LÖNEKONTO","2222");
      kontoLista[1] = new Konto("SPARKONTO","4444", 25000);
      kontoLista[2] = new Konto("FONDKONTO","8888", 50000);
   }

   public void run() {

      while (true) {
         System.out.println();
         System.out.println("Välkommen till banken!");
         System.out.println();
         System.out.println("1. Logga in");
         System.out.println("2. Avsluta");
         System.out.println();
         System.out.print("Ange ditt val: ");
         int val = scanner.nextInt();

         switch (val) {
            case 1:
               System.out.println();
               System.out.println("Välj det konto du vill göra transaktioner på");
               System.out.println("genom att ange PIN-koden för det kontot.");
               System.out.println();
               System.out.println("Lönekontot      Sparkontot      Fondkontot");
               System.out.println();
               System.out.print("Ange PIN-kod: ");
               String angivenKod = scanner.next();

               for(int i = 0; i < kontoLista.length; i++){
                  if(kontoLista[i].testPin(angivenKod)){
                     aktivtKonto = kontoLista[i];
                     bankOperations();
                     break;
                  }
               }

               System.out.println("Felaktig PIN-kod!");
               System.out.println("Vänligen försök igen.");

               break;
            case 2:
               System.out.println();
               System.out.println();
               System.out.println("Avslutar bankbesöket.");
               System.out.println("Välkommen åter!");
               System.exit(0);
            default:
               System.out.println();
               System.out.println();
               System.out.println("Felaktigt val!");
               System.out.println("Vänligen försök igen.");
               System.out.println();
               System.out.println();
               break;
         }
      }
   }

   // Genomför insättning eller uttag från valt konto
   private void bankOperations() {
      while (true) {
         System.out.println("Bank Meny:");
         System.out.println();
         System.out.println(aktivtKonto.getKontoTyp());
         System.out.println();
         System.out.println("1. Insättning");
         System.out.println("2. Uttag");
         System.out.println("3. Åter till huvudmenyn");
         System.out.println();
         System.out.print("Ange ditt val: ");
         int val = scanner.nextInt();

         switch (val) {
            case 1:
               System.out.print("Ange beloppet du önskar sätta in: ");
               int summaInsatt = scanner.nextInt();

               if(aktivtKonto.insattning(summaInsatt)){
                  visaValorer(summaInsatt);
                  System.out.println();
                  System.out.println("Nytt saldo: " + aktivtKonto.getSaldo() + " SEK");
               }else{
                  System.out.println();
                  System.out.println("Kan inte sätta in negativt belopp");
               }

               break;
            case 2:
               System.out.println();
               System.out.print("Ange beloppet du önskar ta ut: ");
               int beloppUttag = scanner.nextInt();
               if (aktivtKonto.uttag(beloppUttag)) {
                  visaValorer(beloppUttag);
                  System.out.println();
                  System.out.println("Nytt saldo: " + aktivtKonto.getSaldo() + " SEK");
               } else {
                  System.out.println();
                  System.out.println("Felaktigt belopp!");
                  System.out.println("Kontrollera saldot");
               }
               break;
            case 3:
               return;
            default:
               System.out.println();
               System.out.println("Felaktigt val!");
               System.out.println("Vänligen försök igen!");
               break;
         }
      }
   }

   private void visaValorer(int summa) {
      int[] valorer = {1000, 500, 200, 100, 50, 20, 10, 5, 1};
      System.out.println();
      System.out.println("Antalet använda sedlar/mynt:");
      for (int valor : valorer) {
         int counter = (summa / valor);
         if (counter > 0) {
            System.out.print(valor + " Kr/antal: " + counter);
            System.out.print("   ");
            summa = summa - (counter * valor);
         }
      }
   }
}
