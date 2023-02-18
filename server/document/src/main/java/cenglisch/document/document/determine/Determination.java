package cenglisch.document.document.determine;

import java.util.ArrayList;
import java.util.Collection;

public interface Determination {
    boolean determine(String fileContent);

    DocumentType getDocumentType();

    static Collection<Determination> getDeterminationPool(){
        var collection = new ArrayList<Determination>();
        collection.add(new AnschreibenDetermination());
        collection.add(new LebenslaufDetermination());
        collection.add(new ZeugnisDetermination());
        return collection;
    }
}
