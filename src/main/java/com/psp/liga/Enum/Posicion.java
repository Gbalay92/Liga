package com.psp.liga.Enum;

public enum Posicion {
    PT {
        @Override
        public String toString() {
            return "PT";
        }
    },
    DF {
        @Override
        public String toString() {
            return "DF";
        }
    },
    MD {
        @Override
        public String toString() {
            return "MD";
        }
    },
    DL {
        @Override
        public String toString() {
            return "DL";
        }
    }
}
