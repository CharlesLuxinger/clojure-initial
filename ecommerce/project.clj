(defproject ecommerce "1.0.0"
  :description "Project to learning Datomic"
  :url "https://github.com/CharlesLuxinger/clojure-initial"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :repositories {"my.datomic.com" {:url "https://my.datomic.com/repo"
                                   :creds :gpg}}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [com.datomic/datomic-pro "1.0.6316"]]
  :repl-options {:init-ns ecommerce.core})
