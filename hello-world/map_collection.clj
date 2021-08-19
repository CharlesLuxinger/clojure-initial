(ns map-collection)/home/ztech

(def inventory {"Bag" 10, "Wallet" 5})

(def inventory {:bag 10, :wallet 5})                        ;keywords

(def order {:bag {:quantity 5, :price 10.4}})

(println (count inventory))
(println (keys inventory))
(println (vals inventory))

(println (inventory :bag))
(println (:bag inventory))
(println (get inventory :bag))

(println (assoc inventory :chair 3))
(println (dissoc inventory :wallet))
(println (update inventory :bag 3))

;Prefix
(println (:price (:bag order)))
(println (update-in order [:bag :quantity] 3))

;Threading First
(println (-> order :bag :quantity))


