(ns hospital.model)

(def empty-queue clojure.lang.PersistentQueue/EMPTY)

(defn new-empty-queue []
  {:wait       empty-queue
   :laboratory1 empty-queue
   :laboratory2 empty-queue
   :laboratory3 empty-queue})