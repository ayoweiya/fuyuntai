package com.naturaltel.vo.db;

import java.io.Serializable;

public class ViewProjectVO implements Serializable {
	private static final long serialVersionUID = 4658244528139671205L;
	
	private int idx;
	private String wuxin;
	private int projectId;
	private String project;
	private String content_free;
	private String content;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getWuxin() {
		return wuxin;
	}
	public void setWuxin(String wuxin) {
		this.wuxin = wuxin;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getContent_free() {
		return content_free;
	}
	public void setContent_free(String content_free) {
		this.content_free = content_free;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "ViewProjectVO [idx=" + idx + ", wuxin=" + wuxin + ", projectId=" + projectId + ", project=" + project
				+ ", content_free=" + content_free + ", content=" + content + "]";
	}
}