(ns store.order
  (:require [store.db :as s.db]
            [store.logic :as s.logic]))

(println (s.logic/resume-by-user (s.db/all-orders)))

(let [orders (s.db/all-orders)
      resume (s.logic/resume-by-user orders)]
  (println "Resume:" resume)
  (println "Ordered:" (sort-by :order-amount resume))
  (println "Order reversed:" (reverse (sort-by :order-amount resume)))

  (println (get-in orders [0 :items :bag :quantity])))

