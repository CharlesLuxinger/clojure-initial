(ns hospital.logic)

(defn queue-limit-size? [hospital department]
  (-> hospital
      (get department)
      count
      (< 5)))

(defn come-in
  [hospital department person]
  (if (queue-limit-size? hospital department)
    (update hospital department conj person)
    (throw (ex-info "Queue is full" {:trying-add person}))))

(defn come-in-sleep
  [hospital department person]
  (if (queue-limit-size? hospital department)
    (do (Thread/sleep 1000)
        (update hospital department conj person))
    (throw (ex-info "Queue is full" {:trying-add person}))))

(defn call
  [hospital department]
  (update hospital department pop))