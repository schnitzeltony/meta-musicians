SUMMARY = "An old-school polyphonic additive synthesizer"
HOMEPAGE = "http://padthv1.sourceforge.net/"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS += " \
    qtbase-native \
    qtbase \
    qtsvg \
    jack \
    lv2 \
    liblo \
    fftw \
"

inherit cmake_qt5 pkgconfig gtk-icon-cache mime mime-xdg

SRC_URI = " \
    ${SOURCEFORGE_MIRROR}/project/${BPN}/${BPN}/${PV}/${BPN}-${PV}.tar.gz \
    file://0002-Avoid-stripping-CMake.patch \
    http://linuxsynths.com/Padthv1PatchesDemos/Padthv1Patches.tar.gz;name=linuxsynths-padthv1-presets;subdir=linuxsynths-padthv1-presets \
    file://padthv1.conf \
"
PV = "0.9.26"
SRC_URI[sha256sum] = "813f818d6c6c66b403937c66a7729ea85226eab17db0992334441613c903ef0a"

SRC_URI[linuxsynths-padthv1-presets.sha256sum] = "ad9eadc707784b6931955b1fc63308b9e5dc59d24903e6405e9d34d30794fd0b"

do_install:append() {
    install -d ${D}/${datadir}/${BPN}
    install -d ${D}/${datadir}/${BPN}/presets
    cp ${WORKDIR}/linuxsynths-padthv1-presets/*.padthv1 ${D}/${datadir}/${BPN}/presets

    install -d ${D}/${sysconfdir}/skel/.config/rncbc.org
    install -m 0644 ${WORKDIR}/${BPN}.conf ${D}/${sysconfdir}/skel/.config/rncbc.org/
}

PACKAGES =+ "${PN}-presets"

FILES:${PN} += " \
    ${datadir}/appdata \
    ${datadir}/mime \
    ${datadir}/metainfo \
    ${datadir}/icons \
    ${libdir}/lv2 \
"

FILES:${PN}-presets += " \
    ${sysconfdir}/skel/.config/rncbc.org \
    ${datadir}/${BPN}/presets/ \
"
