(ns filter)


(def pedido {:mochila  {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}
             :chaveiro {:quantidade 1}})

(defn gratuito?
      [item]
      (<= (get item :preco 0) 0))

(printl (filter gratuito? (vals pedido)))

(defn gratuito?
      [item]
      (<= (get item :preco 0) 0))

(printl
      (filter
            (fn [[_ item]]
                (gratuito? item))
            pedido))

(printl
      (filter
            #(gratuito? (second %))
            pedido))

(println pago? [item] (not (gratuito? item)))

(println pago? [item] (comp not gratuito?))