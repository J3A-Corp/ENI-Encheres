package bll;

import bo.Enchere;
import dal.DAOEnchere;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnchereServiceImpl implements EnchereService{


    private DAOEnchere daoEnchere;

    public EnchereServiceImpl(DAOEnchere daoEnchere) {
        this.daoEnchere = daoEnchere;
    }

    @Override
    public void addEnchere(Enchere enchere) {
        daoEnchere.create(enchere);
    }

    @Override
    public void deleteEnchere(int noArticle, int noUtilisateur) {
        daoEnchere.delete(noArticle, noUtilisateur);
    }

    @Override
    public List<Enchere> getEnchere() {
        return daoEnchere.read();
    }

    @Override
    public Enchere getEnchereByNoArticleNNoUtilisateur(int noArticle, int noUtilisateur) {
        return daoEnchere.read(noArticle, noUtilisateur);
    }

    @Override
    public void updateEnchere(Enchere enchere) {
        daoEnchere.update(enchere);
    }
}
