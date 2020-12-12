package madrigal.adriana.tarea03.bl.tipos;

public enum TipoAudio {
    DVD,
    CASETTE,
    CD;

    public TipoAudio conversionTipoAudio(String tipo){

        switch (tipo){
            case "CD":
               return CD ;
            case "CASETTE":
                return CASETTE;
            case "DVD":
                return DVD;
        }

        return null;

    }

}

