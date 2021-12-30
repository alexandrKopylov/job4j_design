package ru.job4j.block5.solid.srp;

/**
 * Представьте себе модуль, который обрабатывает заказы.
 * Если заказ верно сформирован, он сохраняет его в базу
 * данных и высылает письмо для подтверждения заказа:
 * нарушает принцип SRP
 * <p>
 * Такой модуль может измениться по трем причинам.
 * Во-первых может стать другой логика обработки заказа,
 * во-вторых, способ его сохранения (тип базы данных),
 * в-третьих — способ отправки письма подтверждения
 * (скажем, вместо email нужно отправлять SMS).
 */

public class OrderProcessor {
    public void process(Order order) {
        if (order.isValid() && save(order)) {
            sendConfirmationEmail(order);
        }
    }

    /**
     * сохраняем заказ в базу данных
     *
     * @param order
     * @return
     */
    private boolean save(Order order) {
        return true;
    }

    /**
     * Шлем письмо клиенту
     *
     * @param order
     */
    private void sendConfirmationEmail(Order order) {
        String name = order.getCustomerName();
        String email = order.getCustomerEmail();
    }

    static class Order {
        boolean isValid() {
            return false;
        }

        String getCustomerName() {
            return null;
        }

        String getCustomerEmail() {
            return null;
        }
    }
}


