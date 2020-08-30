(ns ch01.modeling)

(def earth {:name       "Earth"
            :moons      1
            :volume     1.08321e12
            :mass       5.97219e24
            :aphelion   152098232
            :perihelion 147098290
            :type       :Planet})

(defrecord Planet [name moon volume mass aphelion perihelion])

;; Positional factory function
(def earth
  (->Planet "Earth" 1 1.08321e12 5.97219e24 152098232 147098290))

;; Map factory function
(def earth
  (map->Planet {:name       "Earth"
                :moons      1
                :volume     1.08321e12
                :mass       5.97219e24
                :aphelion   152098232
                :perihelion 147098290}))
