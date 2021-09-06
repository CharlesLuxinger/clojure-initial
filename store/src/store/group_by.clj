(ns store.group-by
  (:require [store.db :as s.db]))

(println (s.db/all-orders))

(println (group-by :user (store.db/all-orders)))

(println (map count (vals (group-by :user (store.db/all-orders)))))

;########################

(->> (s.db/all-orders)
     (group-by :user)
     vals
     (map count)
     println)

;########################

(defn count-orders-by-user
  [[user orders]]
  {:user-id        user,
   :order-quantity (count orders)})

(->> (s.db/all-orders)
     (group-by :user)
     (map count-orders-by-user)
     println)

;########################
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

(->> (s.db/all-orders)
     (group-by :user)
     (map quantity-of-orders-and-orders-amount)
     println)