(ns predicates)

; PREDICATE
(defn aplica-desconto?
      [valor-bruto]
      (if (> valor-bruto 100)
        true
        false))

(defn aplica-desconto?
      [valor-bruto]
      (if (> valor-bruto 100)
        true))

(defn aplica-desconto?
      [valor-bruto]
      (when (> valor-bruto 100)
            true))

(defn aplica-desconto?
      [valor-bruto]
      (> valor-bruto 100))


(defn valor-descontado
      [valor-bruto]
      (if (aplica-desconto? valor-bruto)
        (let [taxa-de-desconto (/ 10 100)
              desconto         (* valor-bruto taxa-de-desconto)]
             (- valor-bruto desconto))
        valor-bruto))

(println (valor-descontado 1000))

(println (valor-descontado 100))