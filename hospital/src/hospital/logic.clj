(ns hospital.logic)

(defn come-in
  [hospital department person]
  (update hospital department conj person))

(defn call
  [hospital department]
  (update hospital department pop))