package expectedData;

import java.util.List;

public class PetModel  {

    /**
     * {
     *   "id": 0,
     *   "category": {
     *     "id": 0,
     *     "name": "string"
     *   },
     *   "name": "doggie",
     *   "photoUrls": [
     *     "string"
     *   ],
     *   "tags": [
     *     {
     *       "id": 0,
     *       "name": "string"
     *     }
     *   ],
     *   "status": "available"
     * }
     */

    private int id;
    private PetCategoryModel category;
    private String name;
    private List<String> photoUrls;
    private List<PetTagsModel> tags;
    private String status;

    public PetModel() {
    }

    public PetModel(int id, PetCategoryModel category, String name, List<String> photoUrls, List<PetTagsModel> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public PetCategoryModel getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public List<PetTagsModel> getTags() {
        return tags;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "PetModel{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + photoUrls +
                ", tags=" + tags +
                ", status='" + status + '\'' +
                '}';
    }
}
