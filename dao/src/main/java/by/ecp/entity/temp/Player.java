package by.ecp.entity.temp;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Vinty on 14.06.2017.
 */
@ToString
@Service
public class Player {
    private Disk disk;

    @Autowired
    public Player(Disk nameDisk){
        this.disk=nameDisk;
    }
}
