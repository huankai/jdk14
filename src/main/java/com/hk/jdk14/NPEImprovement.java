package com.hk.jdk14;


/**
 * NullPointerException 改进
 * 在之前的版本中，嵌套属性层级调用时，很容易出现 NullPointerException，且错误信息中，并不知道是哪个属性为空导致的
 * 在JDK 14 中，可以在 VM 中加入如下参数，在出现 NullPointerException后，可以很明确的知道是哪个属性为空
 * -XX:+ShowCodeDetailsInExceptionMessages
 */
public class NPEImprovement {

    public static void main(String[] args) {
        Bank bank = new Bank();
        //嵌套属性层级调用时，很容易出现  NullPointerException
        //报错信息: Exception in thread "main" java.lang.NullPointerException: Cannot read field "card" because "bank.customer" is null
        System.out.println(bank.customer.card);
    }

    private static class Bank {

        private Customer customer;

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }

        public Customer getCustomer() {
            return customer;
        }
    }

    private static class Customer {

        private Card card;

        public void setCard(Card card) {
            this.card = card;
        }

        public Card getCard() {
            return card;
        }
    }

    private static class Card {

        private String no;

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }
    }

}


