(ns loop)

(def vector ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])

(defn conta
      [elementos]
      (loop [total-ate-agora 0
             elementos-restantes elementos]
            (if (seq elementos-restantes)
              (recur (inc total-ate-agora) (next elementos-restantes)))))

(println (conta vector))