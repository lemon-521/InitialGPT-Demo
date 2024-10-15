/**
 * RM2PT Generator Runtime
 * generated by RM2PT v1.3.0
 */
package com.rm2pt.generator.initialgpt;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.rm2pt.generator.initialgpt.CodeGenerator;
import com.rm2pt.generator.initialgpt.SetController;
import java.io.File;
import java.io.FileInputStream;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.generator.GeneratorContext;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class CodeGeneratorHandler extends AbstractHandler implements IHandler {
  @Inject
  private CodeGenerator generator;
  
  @Inject
  private Provider<EclipseResourceFileSystemAccess2> fileAccessProvider;
  
  @Inject
  private IResourceSetProvider resourceSetProvider;
  
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    ISelection selection = HandlerUtil.getCurrentSelection(event);
    if ((selection instanceof IStructuredSelection)) {
      IStructuredSelection structuredSelection = ((IStructuredSelection) selection);
      Object firstElement = structuredSelection.getFirstElement();
      if ((firstElement instanceof IFile)) {
        this.generateCode(((IFile)firstElement));
      }
    } else {
      if ((selection instanceof TextSelection)) {
        IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
        final IFile file = activeEditor.getEditorInput().<IFile>getAdapter(IFile.class);
        this.generateCode(file);
      }
    }
    return null;
  }
  
  private File fxmlfile;
  
  private File pomfile;
  
  private byte[] b;
  
  private FileInputStream fis = null;
  
  public Object generateCode(final IFile file) {
    try {
      IProject project = file.getProject();
      String _name = project.getName();
      String _plus = ("project: " + _name);
      System.out.println(_plus);
      IFolder srcGenFolder = project.getFolder("src-gen");
      boolean _exists = srcGenFolder.exists();
      boolean _not = (!_exists);
      if (_not) {
        try {
          NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
          srcGenFolder.create(true, true, _nullProgressMonitor);
        } catch (final Throwable _t) {
          if (_t instanceof CoreException) {
            return null;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
      final EclipseResourceFileSystemAccess2 fsa = this.fileAccessProvider.get();
      fsa.setProject(project);
      fsa.setOutputPath("src-gen");
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      fsa.setMonitor(_nullProgressMonitor);
      final URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
      ResourceSet rs = this.resourceSetProvider.get(project);
      Resource r = rs.getResource(uri, true);
      IPath _location = Platform.getLocation();
      String _plus_1 = ("\n getlocation: " + _location);
      System.out.println(_plus_1);
      SetController.setLoadfxml(Platform.getLocation().toString(), project.getName());
      SetController.setpom(Platform.getLocation().toString(), project.getName());
      GeneratorContext _generatorContext = new GeneratorContext();
      SetController.setBlock(
        Platform.getLocation().toString(), 
        project.getName(), 
        this.generator.doGenerate(r, fsa, _generatorContext, project.getName()));
      GeneratorContext _generatorContext_1 = new GeneratorContext();
      SetController.setLoadEntityManager(
        Platform.getLocation().toString(), project.getName(), 
        this.generator.doGenerate1(r, fsa, _generatorContext_1, project.getName()));
      SetController.setpomEntity(Platform.getLocation().toString(), project.getName());
      GeneratorContext _generatorContext_2 = new GeneratorContext();
      SetController.setChatClient(
        Platform.getLocation().toString(), project.getName(), 
        this.generator.doGenerate_ChatClient(r, fsa, _generatorContext_2, project.getName()));
      GeneratorContext _generatorContext_3 = new GeneratorContext();
      SetController.setOpenAiSpeaker(
        Platform.getLocation().toString(), project.getName(), 
        this.generator.doGenerate_OpenAiSpeaker(r, fsa, _generatorContext_3, project.getName()));
      return null;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public boolean isEnabled() {
    return true;
  }
}