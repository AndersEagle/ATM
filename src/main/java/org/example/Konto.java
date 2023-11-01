package org.example;

public class Konto {

   // Definition av saldo, PIN-kod samt vilket kontoslag
   private int saldo;
   private String pin;
   private String kontoTyp;


   // Denna konstruktor definierar och skapar ett objekt av klassen "Konto" och
   // initialiserar dess attribut pin, saldo och kontoTyp med de värden som
   // passerades som parametrar när objektet skapas. Det används för att sätta
   // upp och konfigurera ett nytt kontoobjekt när det skapas.
   public Konto(String kontoTyp, String pin, int saldo){
      this.pin = pin;
      this.saldo = saldo;
      this.kontoTyp = kontoTyp;
   }

   // Koden skapar ett "Konto"-objekt med de angivna parametrarna
   // och ett standardsaldo på 10 000
   public Konto(String kontoTyp, String pin){
      this(kontoTyp,pin, 10000);
   }

   // Den här metoden används för att hämta/erhålla värdet av
   // attributet 'kontoTyp' för ett specifikt "Konto"-objekt.
   public String getKontoTyp(){
      return kontoTyp;
   }

   // Används för att försöka genomföra ett uttag från ett konto.
   // Den returnerar 'true' om uttaget lyckas och 'false' om uttaget
   // inte kan genomföras p.g.a. av otillräckligt saldo eller
   // ett negativt belopp.
   public boolean uttag(int belopp){
      if(belopp > saldo || belopp < 0)
         return false;
      else {
         saldo = saldo - belopp;
         return true;
      }
   }

   public boolean insattning(int belopp){
      if(belopp < 0)
         return false;
      else{
         saldo = saldo + belopp;
         return true;
      }
   }

   public int getSaldo(){
      return saldo;
   }

   // Denna metod används för att testa om den inkommande
   // PIN-koden (pin) är lika med den interna PIN-koden (this.pin)
   // som är lagrad i det aktuella objektet. Den returnerar 'true' om
   // de är lika och 'false' om de inte är det.
   public boolean testPin(String pin){
      return this.pin.equals(pin);
   }
}
