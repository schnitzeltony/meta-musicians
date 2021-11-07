SUMMARY = "A linux editor for the Akai LPD8"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=6dc9df5fa3108f437a4580b0aebca196"

inherit pkgconfig qmake5 gtk-icon-cache

DEPENDS += " \
    qtbase \
    qtsvg \
    alsa-lib \
"

SRC_URI = " \
    git://github.com/charlesfleche/lpd8editor.git;branch=master;protocol=https \
    file://0001-Remove-Werror-from-CXXFLAGS.patch\
    file://lpd8-editor.desktop \
"
SRCREV = "c5b3a64487b3f126f9da15e94d547eff8e972c0c"
PV = "0.0.13"
S = "${WORKDIR}/git"

do_install:append() {
    install -Dm 644 ${WORKDIR}/lpd8-editor.desktop ${D}/${datadir}/applications/lpd8-editor.desktop
    install -Dm 644 ${S}/lpd8editor.svg ${D}/${datadir}/icons/hicolor/scalable/apps/lpd8-editor.svg
}
