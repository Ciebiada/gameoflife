(ns gameoflife.core)
(require 'gameoflife.life)
(refer 'gameoflife.life)

(def esc
  (char 27))

(defn clear-screen []
  (print (str esc "[2J" esc "[f")))

(defn print-cell [[x y]]
  (print (str esc "[" y ";" x "f#")))

(defn print-cells [cells]
  (doseq [cell cells] (print-cell cell)))

(def random-cells
  (repeatedly (fn [] [(rand-int 80) (rand-int 20)])))

(defn main []
  (loop [board (next-generation (set (take 300 random-cells)))]
    (do
      (clear-screen)
      (print-cells board)
      (flush)
      (Thread/sleep 200)
      (recur (next-generation board)))))

