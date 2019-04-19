package com.jitterted;

import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

public class JitterChatToolWindowFactory implements ToolWindowFactory, DumbAware {
  // Create the tool window content.
  public void createToolWindowContent(Project project, ToolWindow toolWindow) {
    ChatToolWindow chatToolWindow = new ChatToolWindow(toolWindow, project);
    ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
    Content content = contentFactory.createContent(chatToolWindow.getContent(), "", false);
    toolWindow.getContentManager().addContent(content);
  }

  @Override
  public void init(ToolWindow window) {
  }

  @Override
  public boolean shouldBeAvailable(@NotNull Project project) {
    return true;
  }

  @Override
  public boolean isDoNotActivateOnStart() {
    return false;
  }
}
