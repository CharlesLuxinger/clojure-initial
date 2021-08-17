(ns high-order-functions)

(defn maior-que-100?
      [valor]
      (> valor 100))

(defn valor-descontado
      [aplica? valor-bruto]
      (if (aplica? valor-bruto)
        (let [taxa-de-desconto (/ 10 100)
              desconto         (* valor-bruto taxa-de-desconto)]
             (- valor-bruto desconto))
        valor-bruto))

(println (valor-descontado maior-que-100? 1000))
(println (valor-descontado maior-que-100? 100))


;Função Anomnima
(println (valor-descontado (fn [valor] (> valor 100)) 1000))
(println (valor-descontado (fn [valor] (> valor 100)) 100))

(println (valor-descontado (fn [v] (> v 100)) 1000))
(println (valor-descontado (fn [v] (> v 100)) 100))

(println (valor-descontado #(> %1 100) 1000))
(println (valor-descontado #(> %1 100) 100))

(println (valor-descontado #(> % 100) 1000))
(println (valor-descontado #(> % 100) 100))