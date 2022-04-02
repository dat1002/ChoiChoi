package com.example.test.services.imp;

import com.example.test.dtos.TrafficDTO;
import com.example.test.exceptions.BadRequestException;
import com.example.test.exceptions.NotFoundException;
import com.example.test.models.Traffic;
import com.example.test.models.User;
import com.example.test.payload.AuthenticationRequest;
import com.example.test.repositories.TrafficRepository;
import com.example.test.repositories.UserRepositories;
import com.example.test.services.ITrafficService;
import com.example.test.utils.ConvertDTOToDAO;
import com.example.test.utils.UploadFile;
import com.github.slugify.Slugify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
public class TrafficServiceImp implements ITrafficService {
    @Autowired
    private TrafficRepository trafficRepository;

    @Autowired
    private UploadFile uploadFile;

    @Autowired
    private SendMailServiceImp sendMailServiceImp;


    @Autowired
    private Slugify slugify;

    @Autowired
    private UserRepositories userRepositories;

    @Override
    public Traffic createNewTraffic(TrafficDTO trafficDTO, Integer idUser) {
        Optional<User> user = userRepositories.findById(idUser);
        if(user.isEmpty()){
            throw new NotFoundException("No user.");
        }
        Traffic oldTraffic = trafficRepository.findByLicensePlate(trafficDTO.getLicensePlate());
        if(oldTraffic != null){
            throw new BadRequestException("User already exists");
        }
        Traffic traffic = new Traffic();
        ConvertDTOToDAO.fromTrafficDTOToTraffic(trafficDTO);
        String code = trafficDTO.getCode().concat("-").concat(trafficDTO.getLicensePlate());
        slugify = slugify.withTransliterator(true);
        traffic.setCode(slugify.slugify(code));

        user.get().getTraffic().add(traffic);
        sendMailServiceImp.sendMailWithText("Hello","Bạn thêm thành công phương tiện có biển số xe là:"+trafficDTO.getLicensePlate(),user.get().getEmail() );

        return trafficRepository.save(traffic);
    }

    @Override
    public Traffic deleteTrafficById(Integer idTraffic) {
        Optional<Traffic> oldTraffic = trafficRepository.findById(idTraffic);
        if(oldTraffic.isEmpty()){
            throw new NotFoundException("Biển số xe không tồn tại trong dữ liệu");
        }
        trafficRepository.deleteById(idTraffic);
        return oldTraffic.get();
    }

    @Override
    public Set<Traffic> getAllTrafficByIdUser(Integer idUser) {
        Optional<User> user = userRepositories.findById(idUser);
        Set<Traffic> traffics = new HashSet<>(trafficRepository.findAllByUserTraffic(idUser));
        if(user.isEmpty()){
            throw new NotFoundException("No user.");
        }
        return traffics;
    }

    @Override
    public Set<Traffic> getAllTraffic() {
        Set<Traffic> traffics = new HashSet<>(trafficRepository.findAll());
        if(traffics.size() == 0){
            throw new NotFoundException("Null");
        }
        return traffics;
    }

    @Override
    public Traffic editTrafficById(TrafficDTO trafficDTO, Integer idTraffic) {
        Traffic traffic = trafficRepository.findById(idTraffic).get();
        if(traffic == null){
            throw new NotFoundException("Không tồn tại xe có id này.");
        }
        return trafficRepository.save(ConvertDTOToDAO.fromTrafficDTOToTraffic(trafficDTO));
    }

    @Override
    public Traffic editAvatarTrafficById(MultipartFile file, Integer idTraffic) {
        Traffic traffic = trafficRepository.findById(idTraffic).get();
        if(traffic == null){
            throw new NotFoundException("Id không tồn tại.");
        }
        traffic.setAvatar(uploadFile.getUrlFromFile(file));
        return trafficRepository.save(traffic);
    }
}
