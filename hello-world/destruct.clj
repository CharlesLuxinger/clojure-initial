(ns destruct)

(def pedido {:mochila  {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})

(defn imprime-e-15 [valor]
      (println "valor" valor)
      15)

(println (map imprime-e-15 pedido))

;##############

(defn imprime-e-15 [valor]
      (println "valor" (class valor) valor)
      15)

(println (map imprime-e-15 pedido))

;##############

(defn imprime-valor [[chave valor]]
      (println chave "<e>" valor)
      valor)

(println (map imprime-valor pedido))

;##############

(defn preco-dos-produtos [[chave valor]]
      (* (:quantidade valor) (:preco valor)))

(println (map preco-dos-produtos pedido))
(println (reduce + (map preco-dos-produtos pedido)))

;##############

(defn preco-dos-produtos [[_ valor]]
      (* (:quantidade valor) (:preco valor)))

(defn total-do-pedido [pedido]
      (reduce + (map preco-dos-produtos pedido)))

(println (total-do-pedido pedido))

;##############

(defn total-do-pedido [pedido]
      (-> pedido
          (map preco-dos-produtos)
          (reduce +))
      (reduce + (map preco-dos-produtos pedido)))

(println (total-do-pedido pedido))

;##############

(defn preco-total-do-produto [produto]
      (* (:quantidade produto) (:preco produto)))

;THREAD LAST
(defn total-do-pedido
      [pedido]
      (->> pedido
           vals
           (map preco-total-do-produto)
           (reduce +)))

(println (total-do-pedido pedido))