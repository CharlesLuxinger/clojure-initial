(ns ecommerce.core
  (:require [datomic.api :as d]
            [ecommerce.db :as db]
            [ecommerce.model :as model]))

(def conn (db/open-connection))

(db/create-schema conn)

(let [computer (model/new-product "New Computer", "/new-computer", 2500.1M)]
  (d/transact conn [computer]))

(db/find-all-products (d/db conn))

(db/find-by-slug (d/db conn) "/new-computer")