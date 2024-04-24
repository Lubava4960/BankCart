package com.Bank.Card;

public class Main {
    public static void main(String[] args) {


        // Создан экземпляр DebitCard с начальным балансом 5000
        DebitCard debitCard = new DebitCard(5000);

        // Создан экземпляр CreditCard с начальным балансом 3000 и кредитным лимитом 10000
        CreditCard creditCard = new CreditCard(3000, 10000);

        // Выводится информация о балансе и доступных средствах для обеих карт
        System.out.println("доступные собственных средств: " + debitCard.getBalance());
        System.out.println("доступно собственных средств на кредитной карте: " + creditCard.getBalance());
        System.out.println("доступны все  средства по кредитной карте : " + creditCard.getAvailableFunds());

        //  оплата покупки

        debitCard.pay(6000);
        boolean debitPaymentResult = debitCard.pay(6000);//результат оплаты по дебетовой кврте
        System.out.println("Все траты по дебетовой карте составляют: " + debitCard.getTotalSpent());

        // информация о балансе и доступных средствах после оплаты
        System.out.println("Доступный баланс дебетовой карты после оплаты: " + debitCard.getBalance());
        System.out.println("Доступные средства на дебетовой карте после оплаты : " + debitCard.getAvailableFunds());
        System.out.println("Баланс собственных средств по кредитной карте : " + creditCard.getBalance());
        System.out.println("Доступные средства на дебетовой карте после оплаты: " + creditCard.getAvailableFunds());
        debitCard.deposit(4000);
        debitCard.deposit(3000);
        System.out.println("Внесено средств: " + debitCard.getTotalDeposited());


        // пополнения карты на 5 000

        creditCard.deposit(5000);
        //  доступные средства на карте
        System.out.println("Сredit Card Balance: " + creditCard.getBalance());//доступные  cобственные средства
        System.out.println("Credit Card Available Funds: " + creditCard.getAvailableFunds());// доступны все средства

        //Кредитная карта с лимитом 10 000:
        //  Кредитные средства: 10 000:
        //  Собственные средства: 0

        CreditCard creditCard2 = new CreditCard(0, 10000);
        System.out.println("Debit Card собственные средства" + creditCard2.getBalance());
        System.out.println("Debit Card кредитных средств: " + creditCard2.getAvailableFunds());

        //  После пополнения карты на 5 000:
        //  Кредитные средства: 10 000.
        //  Собственные средства: 5000:

        //  пополнение
        creditCard2.deposit(5000);
        System.out.println("Пополнение карты на 5000");

        System.out.println("Доступно собственных cредств: " + creditCard2.getBalance());
        System.out.println("Доступно кредитных средств" + creditCard2.getCreditLimit());
        System.out.println("Общий лимит по карте: " + creditCard2.getAvailableFunds());


        //   После оплаты на 7 000:
        //   Собственные средства: 0.
        //   Кредитные средства: 8 000.
        //   Всего доступно средств:8000

        creditCard2.pay(7000);
        System.out.println("Оплачена покупка на 7000");
//        boolean creditPaymentResult = creditCard2.pay(purchaseAmount);
        //System.out.println("Peзультат оплаты после оплаты по кредитной карте : " + creditPaymentResult);//результат оплаты
        System.out.println("Собственных средствв после оплаты: " + creditCard2.getBalance());
        System.out.println("Крeдитных средств после оплаты:" + creditCard2.getCreditLimit());
        System.out.println("Всего средств после оплаты:  " + creditCard2.getAvailableFunds());


        //  После пополнения на 2 000:
        //  Кредитные средства: 10 000.
        //  Собственные средства: 2000.


        // пополнение
        creditCard2.deposit(2000);
        System.out.println("Пополнение карты на 2000");

        System.out.println("Доступно собственных cредств: " + creditCard2.getBalance());
        System.out.println("Доступно кредитных средств: " + creditCard2.getCreditLimit());
        System.out.println("Общий лимит по карте: " + creditCard2.getAvailableFunds());

       // Создан экземпляр DebitCardBonus с начальным балансом 1000 co ставкoй бонуса 1%
        DebitCardBonus card = new DebitCardBonus(1000, 0.01);
        // Проверка начисления бонусов при оплате
        card.pay(500); // Оплачено 500
        System.out.println("Доступные средства: " + card.getAvailableFunds()); // Доступные средства: 505 с бонусами

        card.pay(200); // Оплачено еще 200
        System.out.println("Доступные средства: " + card.getAvailableFunds()); // Доступные средства: 300 (без учета бонусов)
        // Ожидаемый вывод: "Начислено бонусных баллов: 3"

        // Проверяем вывод доступных средств без использования метода платы
        System.out.println("Доступные средства: " + card.getAvailableFunds()); // Доступные средства: 303 (с учетом бонусов)

       // Создан экземпляр DebitCardCashback с начальным балансом 20000
        DebitCartCashback debitCartCashback = new DebitCartCashback(20000);
        debitCartCashback.pay(8000);
        debitCartCashback.pay(7000);
        System.out.println("общая сумма начисленного кэшбэка: " + debitCartCashback.calculateTotalCashback());
        System.out.println("Общая суммa трат: "+ debitCartCashback.getTotalSpent());
        debitCartCashback.deposit(300);
        debitCartCashback.deposit(400);
        double totalDeposited = debitCartCashback.getTotalDeposited();
        System.out.println("Пополнено на сумму: " + totalDeposited);
        System.out.println("Общая сумма начисленного процентного  бонуса за пополнение: " + debitCartCashback.calculateTotalDepositBonus());

        // Создан экземпляр CreditCardBonus с начальным балансом 1000 c кредитным лимитом 10000
        CreditCardBonus creditCardBonus = new CreditCardBonus(1000, 10000, 0.01);
        //  Начальный баланс
        System.out.println("Начальный баланс: " + creditCardBonus.getBalance());

        // Оплата покупки с начислением бонусов
        creditCardBonus.payWithBonus(500);

        // Выводим баланс после покупки
        System.out.println("Баланс собственные средства " + creditCardBonus.getBalance());

        creditCardBonus.printCreditBalance(creditCardBonus.getBalance());
        System.out.println("Баланс кредитных средств: " + creditCardBonus.getCreditLimit());


        // Кредитная карта с кэшбэком
        CreditCardCashback creditCardCashback= new CreditCardCashback(2000,10000);

        // Получение информации о кредитной карте
        System.out.println("Собственные средства : " + creditCardCashback.getBalance());
        System.out.println("Кредитный лимит: " + creditCardCashback.getCreditLimit());
        System.out.println("Доступные средства: " + creditCardCashback.getAvailableFunds());

        creditCardCashback.pay(3000);
        creditCardCashback.pay(6000);
        System.out.println("общая сумма начисленного кэшбэка: " + creditCardCashback.calculateTotalCashback());
        System.out.println("Общая сумма трат: " + creditCardCashback.getTotalSpent());
//        // Получение информации о кредитной карте после оплаты
        System.out.println("Собственные средства : " + creditCardCashback.getBalance());
        System.out.println("Кредитный лимит: " + creditCardCashback.getCreditLimit());
        System.out.println("Доступные средства: " + creditCardCashback.getAvailableFunds());
        creditCardCashback.deposit(200);
        creditCardCashback.deposit(600);
        double totalDepositedCreditCart = creditCardCashback.getTotalDepositedCreditCard();
        System.out.println("Пополнено на сумму: " + totalDepositedCreditCart);

        System.out.println("общая сумма начисленного процентного  бонуса за пополнение: " + creditCardCashback.calculateTotalDepositBonus());

    }




    }













