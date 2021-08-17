(ns map)

(def prices [30 700 1000])

(defn apply-discount?
      [valor-bruto]
      (> valor-bruto 100))

(defn value-discounted
      [valor-bruto]
      (if (apply-discount? valor-bruto)
        (let [taxa-de-desconto (/ 10 100)
              desconto         (* valor-bruto taxa-de-desconto)]
             (- valor-bruto desconto))
        valor-bruto))


(println (map value-discounted prices))

(println (range 10))
(println (filter even? (range 10)))

(println (filter apply-discount? prices))

(println
  (map value-discounted
       (filter
         apply-discount?
         prices)))