(println "Hello World")

(def product-amount 15)

(println "Amount:" product-amount)

(+ product-amount 3)

(def product-amount (+ product-amount 3))

(def  products ["Car", "TV"])

(products 0)

(count products)

(def products (conj products "Chair"))

(defn print-message []
    (println "Hello World"))

(defn value-discounted [value]
    (* value (- 1 0.1)))

(defn value-discounted [value]
    (let [discount (/ 10 100)]
        (* value (- 1 discount))))

(if (> 500 100)
    (println "Greater than")
    (println "Less or equal than"))

(defn value-discounted [value]
    (if (> value 100)
        (let [discount (/ 10 100)]
          (* value (- 1 discount)))
       value))