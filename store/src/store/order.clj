(ns store.order
  (:require [store.db :as s.db]
            [store.logic :as s.logic]))

(println (s.logic/resume-by-user (s.db/all-orders)))

(let [orders (s.db/all-orders)
      resume (s.logic/resume-by-user orders)]
  (println "Resume:" resume)
  (println "Ordered:" (sort-by :order-amount resume))
  (println "Order reversed:" (reverse (sort-by :order-amount resume)))

  (println "First:" (first resume))
  (println "Second:" (second resume))
  (println "Fourth Element:" (nth resume 4))
  (println "Only 2 Elements:" (take resume 2))

  (println (get-in orders [0 :items :bag :quantity])))

