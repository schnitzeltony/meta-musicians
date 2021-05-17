SUMMARY = "An old-school polyphonic additive synthesizer"
HOMEPAGE = "http://padthv1.sourceforge.net/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS += " \
    qtbase-native \
    qtbase \
    jack \
    lv2 \
    liblo \
    fftw \
"

inherit cmake_qt5 gtk-icon-cache mime

SRC_URI = " \
    ${SOURCEFORGE_MIRROR}/project/${BPN}/${BPN}/${PV}/${BPN}-${PV}.tar.gz \
    file://0002-Avoid-stripping-CMake.patch \
    http://linuxsynths.com/Padthv1PatchesDemos/Padthv1Patches.tar.gz;name=linuxsynths-padthv1-presets;subdir=linuxsynths-padthv1-presets \
    file://padthv1.conf \
"
PV = "0.9.22"
SRC_URI[sha256sum] = "dd445359803e9bbb6f43af53841054c80e77c197aca2d88c4172301cd24e7ef2"

SRC_URI[linuxsynths-padthv1-presets.sha256sum] = "ad9eadc707784b6931955b1fc63308b9e5dc59d24903e6405e9d34d30794fd0b"

do_install_append() {
    install -d ${D}/${datadir}/${BPN}
    install -d ${D}/${datadir}/${BPN}/presets
    cp ${WORKDIR}/linuxsynths-padthv1-presets/*.padthv1 ${D}/${datadir}/${BPN}/presets

    install -d ${D}/${sysconfdir}/skel/.config/rncbc.org
    install -m 0644 ${WORKDIR}/${BPN}.conf ${D}/${sysconfdir}/skel/.config/rncbc.org/
}

PACKAGES =+ "${PN}-presets"

FILES_${PN} += " \
    ${datadir}/appdata \
    ${datadir}/mime \
    ${datadir}/metainfo \
    ${datadir}/icons \
    ${libdir}/lv2 \
"

FILES_${PN}-presets += " \
    ${sysconfdir}/skel/.config/rncbc.org \
    ${datadir}/${BPN}/presets/ \
"
