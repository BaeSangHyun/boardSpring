package kr.or.ddit.post.model;

public class PostFile {
    private String fileId;
    private String postId;
    private String fileNm;
    private String realFilePath;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getFileNm() {
        return fileNm;
    }

    public void setFileNm(String fileNm) {
        this.fileNm = fileNm;
    }

    public String getRealFilePath() {
        return realFilePath;
    }

    public void setRealFilePath(String realFilePath) {
        this.realFilePath = realFilePath;
    }

    @Override
    public String toString() {
        return "PostFile{" +
                "fileId='" + fileId + '\'' +
                ", postId='" + postId + '\'' +
                ", fileNm='" + fileNm + '\'' +
                ", realFilePath='" + realFilePath + '\'' +
                '}';
    }
}
