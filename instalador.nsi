# Idiomas

# Nombre del instalador
Name "Instalador Grupo Miguel"

# The file to write
OutFile "GrupoMiguel.exe"

# The default installation directory
InstallDir $PROGRAMFILES\GrupoMiguel

# Pedimos permisos para Windows 7
RequestExecutionLevel admin

# Pantallas que hay que mostrar del instalador

Page directory
Page instfiles

#Cambiar el idioma
!include "MUI.nsh"
!insertmacro MUI_PAGE_INSTFILES
!insertmacro MUI_LANGUAGE "Spanish"

#Seccion principal
Section

  # Establecemos el directorio de salida al directorio de instalacion
  SetOutPath $INSTDIR
  
  # Creamos el desinstalador
  writeUninstaller "$INSTDIR\uninstall.exe"

  # Ponemos ahi el archivo
  File twitter.jar
  File /r "lib"
  File /r "reports"
  File /r "help"

  createShortCut "$SMPROGRAMS\GrupoMiguel.lnk" "$INSTDIR\twitter.jar"
  createShortCut "$DESKTOP\GrupoMiguel.lnk" "$INSTDIR\twitter.jar"
  createShortCut "$SMPROGRAMS\DesinstalarGrupoMiguel.lnk" "$INSTDIR\uninstall.exe"
   
  
# Fin de la seccion
SectionEnd

# seccion del desintalador
section "uninstall"
 
    # borramos el desintalador primero
	delete "$INSTDIR\twitter.jar"
    delete "$INSTDIR\uninstall.exe"
 
    # borramos el acceso directo del menu de inicio
    delete "$INSTDIR\twitter.jar"
	RmDir /r "$INSTDIR\lib"
    RmDir /r "$INSTDIR\reports"
    RmDir /r "$INSTDIR\help"
    delete "$SMPROGRAMS\GrupoMiguel.lnk"
    delete "$DESKTOP\GrupoMiguel.lnk"	
	delete "$SMPROGRAMS\DesinstalarGrupoMiguel.lnk"
    RmDir "$INSTDIR"
 
	#Borramos la entrada del registro
	DeleteRegKey HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\GrupoMiguel"
 
# fin de la seccion del desinstalador
sectionEnd
