(ns ch01.convert)

(defmulti convert
          "Convert quantity from unit1 to unit2, matching on [unit1 unit2]"
          (fn [unit1 unit2 _quantity] [unit1 unit2]))

(defmethod convert [:lb :oz] [_ _ lb] (* lb 16))

(defmethod convert [:oz :lb] [_ _ oz] (/ oz 16))

(defmethod convert :default [unit1 unit2 quantity]
  (if (= unit1 unit2)
    quantity
    (assert false (str "Unknown unit conversion from " unit1 " to " unit2))))

(defn ingredient+
  "Add two ingredients into a single ingredient,
  combining their quantities with unit conversion if necessary."
  [{quantity1 :quantity unit1 :unit :as ingredient} {quantity2 :quantity unit2 :unit}]
  (assoc ingredient :quantity (+ quantity1 (convert unit2 unit1 quantity2))))
