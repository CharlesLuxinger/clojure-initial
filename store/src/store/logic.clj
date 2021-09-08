(ns store.logic)

(defn item-amount
  [[_ details]]
  (* (get details :quantity 0) (get details :unit-price 0)))

(defn order-amount
  [order]
  (reduce + (map item-amount order)))

(defn orders-amount
  [orders]
  (->> orders
       (map :items)
       (map order-amount)
       (reduce +)))

(defn quantity-of-orders-and-orders-amount
  [[user orders]]
  {:user-id        user,
   :order-quantity (count orders)
   :order-amount   (orders-amount orders)})

(defn resume-by-user [orders]
  (->> orders
       (group-by :user)
       (map quantity-of-orders-and-orders-amount)))

(defn resume-by-user-ordered-by-order-amount [orders]
  (->> orders
       (sort-by :order-amount)))
