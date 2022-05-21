SUMMARY = "A linux editor for the Akai LPD8"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=6dc9df5fa3108f437a4580b0aebca196"

inherit cmake_qt5 pkgconfig gtk-icon-cache

DEPENDS += " \
    qttools-native \
    qttools \
    qtbase \
    qtsvg \
    alsa-lib \
"

SRC_URI = " \
    git://github.com/charlesfleche/lpd8editor.git;branch=master;protocol=https \
    file://lpd8-editor.desktop \
"
SRCREV = "ae9072e58d23d5926ca8d0228400eead9248a494"
PV = "0.0.16"
S = "${WORKDIR}/git"

do_install:append() {
    install -Dm 644 ${WORKDIR}/lpd8-editor.desktop ${D}/${datadir}/applications/lpd8-editor.desktop
    install -Dm 644 ${S}/lpd8editor.svg ${D}/${datadir}/icons/hicolor/scalable/apps/lpd8-editor.svg
}
