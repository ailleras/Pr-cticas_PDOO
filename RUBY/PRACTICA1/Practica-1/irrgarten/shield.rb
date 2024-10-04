# frozen_string_literal: true
module Irrgarten
  class Shield
    attr_reader :protection, :uses

    def initialize(protection,uses)
      @protection = protection.to_f
      @uses = uses.to_i
    end

    def protect
      if @uses > 0
        @uses -= 1
        @protection
      else
        0
      end
    end

    def to_s
      "W[#{@protection},#{@uses}]"
    end

    def discard
      Dice.discard_element(@uses)
    end
  end
end
