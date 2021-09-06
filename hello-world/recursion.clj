(ns hello-world.recursion)

;["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"] #VECTOR
;{ "guilherme" 37, "paulo" 39} #MAP
;'(1 2 3 4 5) #ARRAY

(def vector ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])

(println (first vector))

;######################

(defn meu-mapa
      [funcao sequencia]
      (let [primeiro (first sequencia)]
           (funcao primeiro)))

(meu-mapa println vector)

;######################

(defn meu-mapa
      [funcao sequencia]
      (let [primeiro (first sequencia)]
           (funcao primeiro)
           (meu-mapa funcao (rest sequencia))
           ))

(meu-mapa println vector)

;######################

(defn meu-mapa
      [funcao sequencia]
      (let [primeiro (first sequencia)]
           (if primeiro
             (funcao primeiro)
             (meu-mapa funcao (rest sequencia)))
           ))

(meu-mapa println vector)

;######################

(defn meu-mapa
      [funcao sequencia]
      (let [primeiro (first sequencia)]
           (if primeiro
             (do
               (funcao primeiro)
               (meu-mapa funcao (rest sequencia))))
           ))

(meu-mapa println vector)
(meu-mapa println ["daniela" false "carlos" "paulo" "lucia" "ana"])

;######################

(defn meu-mapa
      [funcao sequencia]
      (let [primeiro (first sequencia)]
           (if (not (nil? primeiro))
             (do
               (funcao primeiro)
               (meu-mapa funcao (rest sequencia))))))

(meu-mapa println vector)
(meu-mapa println ["daniela" false "carlos" "paulo" "lucia" "ana"])
(meu-mapa println [])
(meu-mapa println nil)

;StackOverflowError Recursion called
(meu-mapa println (range 1000))

(defn meu-mapa
      [funcao sequencia]
      (let [primeiro (first sequencia)]
           (if (not (nil? primeiro))
             (do
               (funcao primeiro)
               (recur funcao (rest sequencia))))))

(meu-mapa println (range 1000))
