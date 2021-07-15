SUMMARY = "An old-school all-digital 4-oscillator subtractive polyphonic synthesizer"
HOMEPAGE = "http://synthv1.sourceforge.net/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS += " \
    qtbase-native \
    qttools-native \
    qtbase \
    jack \
    lv2 \
    liblo \
"

inherit cmake_qt5 gtk-icon-cache mime

SRC_URI = " \
    ${SOURCEFORGE_MIRROR}/project/${BPN}/${BPN}/${PV}/${BPN}-${PV}.tar.gz \
    file://0002-Avoid-stripping-CMake.patch \
    ${SOURCEFORGE_MIRROR}/project/autostatic/autostatic-synthv1-presets/autostatic-synthv1-presets1.tar.gz;name=autostatic-synthv1-presets1 \
    http://linuxsynths.com/Synthv1PatchesDemos/Synthv1Patches06.tar.gz;name=linuxsynths-synthv1-presets;subdir=linuxsynths-synthv1-presets \
    \
    file://synthv1.conf \
"
PV = "0.9.23"
SRC_URI[sha256sum] = "d15ef64f9d62713fedf5f25fe26c1c31864b8f34cf9e68826d4f817709c29b0e"

SRC_URI[autostatic-synthv1-presets1.sha256sum] = "587ac8cb4cb645fc71603d1b4b351b24f3e4d9f15a53aca59c0f30cc9f66e253"

SRC_URI[linuxsynths-synthv1-presets.sha256sum] = "cd444ccecafa9c03b890b3662455e3c1f36e18cd8f2f9b5c269bf1e4eb6cfa72"

do_install_append() {
    install -d ${D}/${datadir}/${BPN}/presets
    cp ${WORKDIR}/autostatic-synthv1-presets1/*.synthv1 ${D}/${datadir}/${BPN}/presets
    cp ${WORKDIR}/linuxsynths-synthv1-presets/*.synthv1 ${D}/${datadir}/${BPN}/presets

    install -d ${D}/${sysconfdir}/skel/.config/rncbc.org
    install -m 0644 ${WORKDIR}/${BPN}.conf ${D}/${sysconfdir}/skel/.config/rncbc.org/
}

PACKAGES =+ "${PN}-presets"

FILES_${PN} += " \
    ${datadir}/appdata \
    ${datadir}/mime \
    ${datadir}/icons \
    ${datadir}/metainfo \
    ${libdir}/lv2 \
"

FILES_${PN}-presets += " \
    ${sysconfdir}/skel/.config/rncbc.org \
    ${datadir}/${BPN}/presets/ \
"
